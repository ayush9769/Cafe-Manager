package com.inn.cafe.POJO;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@NamedQuery(name = "Product.getAllProduct", query = "select new com.inn.cafe.wrapper.ProductWrapper(p.id, p.name, p.description ,p.price, p.category.name,p.category.id, p.status) from Product p")

@NamedQuery(name = "Product.updateProductStatus", query = "update Product p set p.status=:status where p.id=:id")

@NamedQuery(name = "Product.getProductById", query = "select new com.inn.cafe.wrapper.ProductWrapper(p.id, p.name) from Product p where p.id=:id ")

@NamedQuery(
        name = "Product.getByCategory",
        query = "SELECT new com.inn.cafe.wrapper.ProductWrapper(p.id, p.name, p.description ,p.price, p.category.name,p.category.id, p.status) " +
                "FROM Product p " +
                "WHERE p.category.id = :id AND p.status = 'false'"
)









@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "product")
public class Product {

    public static final long serialVersionUID = 123456L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_fk", nullable = false)
    private Category category;

    @Column(name = "price")
    private Integer price;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;
}
