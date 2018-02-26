package db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import db.tables.ProductsDB;
import objects.ProductOBJ;

public class InventoryMapper implements RowMapper<ProductOBJ>{

	@Override
	public ProductOBJ mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		ProductOBJ prod = new ProductOBJ();
        prod.setID(rs.getInt(ProductsDB.ID));
        prod.setPRODUCT_NAME(rs.getString(ProductsDB.PRODUCT_NAME));
        prod.setPRODUCT_IMG(rs.getString(ProductsDB.PRODUCT_IMG));
        prod.setAISLE(rs.getInt(ProductsDB.AISLE));
        prod.setCOUPON(rs.getString(ProductsDB.COUPON));
        prod.setITEM_CODE(rs.getString(ProductsDB.ITEM_CODE));
        prod.setSKU(rs.getString(ProductsDB.SKU));
        prod.setPERISHABLE(rs.getString(ProductsDB.PERISHABLE));
        prod.setQUANTITY_OFF_FLOOR(rs.getInt(ProductsDB.QUANTITY_OFF_FLOOR));
        prod.setQUANTITY_ON_FLOOR(rs.getInt(ProductsDB.QUANTITY_ON_FLOOR));
        prod.setVENDOR(rs.getInt(ProductsDB.VENDOR));
        prod.setRETAIL_PRICE(rs.getDouble(ProductsDB.RETAIL_PRICE));
        prod.setPURCHASE_PRICE(rs.getDouble(ProductsDB.PURCHASE_PRICE));
        prod.setSUB_CATEGORY(rs.getString(ProductsDB.SUB_CATEGORY));
        prod.setSHELF_LIFE_OFF_FLOOR(rs.getInt(ProductsDB.SHELF_LIFE_OFF_FLOOR));
        prod.setSHELF_LIFE_ON_FLOOR(rs.getInt(ProductsDB.SHELF_LIFE_ON_FLOOR));
        prod.setTAX(rs.getString(ProductsDB.TAX));
        System.out.println("Tax: "+prod.getTAX());
        prod.setTAXABLE(rs.getString(ProductsDB.TAXABLE));
        prod.setCREATED_AT(rs.getDate(ProductsDB.CREATED_AT));
        prod.setREMARKS(rs.getString(ProductsDB.REMARKS));
		
		
		return prod;
	}

}
