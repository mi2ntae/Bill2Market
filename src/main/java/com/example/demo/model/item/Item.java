package com.example.demo.model.item;

import lombok.*;
import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;




@Getter

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="Item")

@NamedNativeQuery(
    name = "SimpleItemSliceByLocation",
    query = "SELECT item.item_id, item_title, item_address, price, p1.item_photo " +
            "FROM item " +
            "LEFT JOIN item_photo_test AS p1 on item.item_id = p1.item_id " +
            "LEFT JOIN item_photo_test AS p2 ON p1.item_id = p2.item_id " +
            "AND p1.photo_index > p2.photo_index " +
            "WHERE p2.photo_index IS NULL " +
            "AND ST_DISTANCE_SPHERE( POINT(:client_longitude, :client_latitude), POINT(item_longitude, item_latitude)) <= 1000 " +
            "ORDER BY ST_Distance_Sphere( POINT(:client_longitude, :client_latitude), POINT(item_longitude, item_latitude))",
    resultSetMapping = "SimpleItemMapping"
)
@SqlResultSetMapping(
        name = "SimpleItemMapping",
        classes = @ConstructorResult(
                targetClass = SimpleItem.class,
                columns = {
                        @ColumnResult(name = "item_id", type = Integer.class),
                        @ColumnResult(name = "item_title", type = String.class),
                        @ColumnResult(name = "item_address", type = String.class),
                        @ColumnResult(name = "price", type = Integer.class),
                        @ColumnResult(name = "item_photo", type = String.class)
                }
        )
)
public class Item {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;
    @Column(name = "owner_index")
    private Integer ownerIndex;
    @Column(name = "category_big")
    private String categoryBig;
    @Column(name = "category_middle")
    private String categoryMiddle;
    @Column(name = "category_small")
    private String categorySmall;
    @Column(name = "item_title")
    private String itemTitle;
    @Column(name = "item_content")
    private String itemContent;
    @Column(name = "item_status")
    private String itemStatus;
    @Column(name = "contract_status")
    private String contractStatus;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "update_date")
    private Date updateDate;
    @Column
    private int price;
    @Column
    private int deposit;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "item_latitude")
    private double itemLatitude;
    @Column(name = "item_longitude")
    private double itemLongitude;
    @Column(name = "item_address")
    private String itemAddress;
    @Column
    private int views;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "item_id")
    @Builder.Default
    private List<ItemPhoto> photos = new ArrayList<ItemPhoto>();


}
