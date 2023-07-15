package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;


    @Test
    void testInvoiceDaoSave() {

        //Given
        Invoice invoice = new Invoice("INV001");

        Product product = new Product("Table");
        Product product1 = new Product("Chair");

        Item item = new Item(product, new BigDecimal(2000),1, new BigDecimal(2000));
        Item item1 = new Item(product1, new BigDecimal(300), 2, new BigDecimal(600));
        Item item2 = new Item(product1, new BigDecimal(200), 10, new BigDecimal(2000));

        List<Item> itemList = new ArrayList<>();
        itemList.add(item);
        itemList.add(item1);
        itemList.add(item2);

        invoice.setItems(itemList);

        item.setInvoice(invoice);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);

        product.getItemList().add(item);
        product1.getItemList().add(item1);
        product1.getItemList().add(item2);

        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();
        int itemSize = invoice.getItems().size();

        //Then
        assertNotEquals(0, id);
        Assertions.assertEquals(3, itemSize);

        //CleanUp
        invoiceDao.deleteAll();
    }
}
