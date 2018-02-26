package fr.asip.mss.transverse.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe d'utilitaire sur les chaines de caractère.
 */
public final class StringUtils {

    /**
     * Méthode permettant de découper un texte en mots.
     * 
     * @param texte
     *            texte
     * @return liste de mots
     */
    public static List<String> decouperMots(String texte) {
        List<String> res = new ArrayList<String>();
        if (texte != null) {
			
            // traitement particulier du caractère " ' " pour zimbra
			String sansCaracteresSpeciaux = texte.replaceAll("[^a-zA-Z0-9àáâãäåòóôõöøèéêëçìíîïùúûüÿñ']", " ");
            String[] mots = sansCaracteresSpeciaux.split(" ");
            String motTrim;
            for (String mot : mots) {
                motTrim = mot.trim();
				// traitement particulier du caractère " ' " pour zimbra
				if (motTrim.contains("'") && motTrim.lastIndexOf("'") == motTrim.length() - 1) {
					motTrim = motTrim.substring(0, motTrim.lastIndexOf("'"));
				}
                if (!motTrim.equals("")) {
                    res.add(motTrim + "*");
                }
            }
        }
        return res;

    }

    /**
     * Transformer une liste d'entiers en une liste de nombres séparés par ,.
     * 
     * @param liste
     *            liste d'entier
     * @return chaine de caractère avec des entiers séparés par ,
     */
    public static String listeToString(List<Integer> liste) {
        String res = "";
        if (liste != null && !liste.isEmpty()) {
            boolean premierItem = true;
            for (Integer item : liste) {
                if (item != null) {
                    if (!premierItem) {
                        res += ",";
                    }
                    res += item.toString();
                    premierItem = false;
                }
            }
        }

        return res;
    }

    /**
     * Méthode permettant de remplacer les caractères spéciaux par des espaces.
     * 
     * @param texte
     *            texte
     * @return liste de mots
     */
    public static String remplacerCaracteresSpeciaux(String texte) {
        String res = "";
        if (texte != null) {
            res = texte.replaceAll("[^a-zA-Z0-9àáâãäåòóôõöøèéêëçìíîïùúûüÿñ]",
                    " ");
        }
        return res;
    }

    public static String remplacerCaracteresSpeciauxEmail(String texte) {
        String res = "";
        if (texte != null) {
            res = texte.replaceAll(
                    "[^@a-zA-Z0-9àáâãäåòóôõöøèéêëçìíîïùúûüÿñ._-]", " ");
        }
        boolean goOn = true;
        while (goOn) {
            if (res.startsWith("-") || res.startsWith(" ")) {
                res = res.substring(1);
            } else {
                goOn = false;
            }
        }
        if (res.contains(" ")) {
            String[] strs = res.split(" ");
            StringBuilder strBuilder = new StringBuilder();
            int count = 0;
            for (String str : strs) {
                if (!str.equals("")) {
                    goOn = true;
                    while (goOn) {
                        if (str.startsWith("-") || str.startsWith(" ")) {
                            str = str.substring(1);
                        } else {
                            goOn = false;
                        }
                    }
                    if (count == 0 || str.equals("")) {
                        strBuilder.append(str);
                        count++;
                    } else {
                        strBuilder.append(" ").append(str);
                    }
                }
            }
            res = strBuilder.toString();
        }
        return res;
    }

    /**
     * Constructeur privé (car classe utilitaire).
     */
    private StringUtils() {
    }
}
