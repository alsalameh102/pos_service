package pos.receipt.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import objects.CartItemOBJ;

/**
* Bean Factory Class which returns a collection of beans
*/
public class BeanFactory {

public static Collection<ReceiptBean> getReceiptBean(List<CartItemOBJ> orderList){
List<ReceiptBean> allbeans = new ArrayList<>();
try {  
	for (CartItemOBJ orderData : orderList) {
		ReceiptBean bean= new ReceiptBean(
				orderData.getDesc(),Integer.valueOf(orderData.getQuantity()) ,orderData.getDesc(), (orderData.getTotalPrice()/orderData.getQuantity()),  orderData.getTotalPrice()
				);
		allbeans.add(bean);
	}

}
catch(Exception e){
e.printStackTrace();
}
return allbeans;  
}
}