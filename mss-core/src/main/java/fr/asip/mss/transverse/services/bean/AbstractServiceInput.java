package fr.asip.mss.transverse.services.bean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Interface des entrées de service d'authentification MSS (privé et public).
 * 
 */
public abstract class AbstractServiceInput {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AbstractServiceInput.class);

	/**
	 * retourne la liste des propriétées de l'entré du service qui ne doivent
	 * pas être échappées.
	 * 
	 * @return liste contenant le nom de chaque propriété à ne pas échapper
	 */
	protected abstract List<String> getPropertyNotToEscape();

	/**
	 * Cette méthode permet d'échapper les caractère spéciaux HTML d'une entrée
	 * de service (entré non fiable). Elle permet de se prémunir d'injections
	 * interpretable par un navigateur.
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws IntrospectionException
	 */
	public void escapeHtmlCharacter() throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			IntrospectionException {
		// Introspection de la classe
		LOGGER.debug("Echappement de {}", this.getClass().getSimpleName());
		BeanInfo serviceInputInfo = Introspector.getBeanInfo(this.getClass());
		PropertyDescriptor[] fields = serviceInputInfo.getPropertyDescriptors();

		// On ajoute les champ à traiter dans une liste
		List<PropertyDescriptor> toEscape = new ArrayList<PropertyDescriptor>();
		for (PropertyDescriptor field : fields) {
			if (!getPropertyNotToEscape().contains(field.getDisplayName())) {
				toEscape.add(field);
			}
		}

		// Analyse de chaque champs demandé
		for (PropertyDescriptor field : toEscape) {
			String fieldName = field.getDisplayName();
			LOGGER.debug("Analyse du champ {}", fieldName);

			// si le champ n'est pas de type string il ne peut pas etre échappé
			if (!String.class.equals(field.getPropertyType())) {
				LOGGER.debug("Le champ {} n'est pas échappé.", fieldName);
				continue;
			}

			// Sinon on échappe la valeur du champ
			String fieldValue = (String) field.getReadMethod().invoke(this);
			String escapedValue = StringEscapeUtils.escapeHtml4(fieldValue);
			field.getWriteMethod().invoke(this, escapedValue);
			if (LOGGER.isDebugEnabled()) {
				if (fieldValue.equals(escapedValue)) {
					LOGGER.debug("La valeur {} du champ {} est resté la même",
							fieldValue, fieldName);
				} else {
					LOGGER.debug(
							"La valeur {} du champ {} a été remplacé par {}",
							fieldValue, fieldName, escapedValue);
				}
			}
		}
	}
}
