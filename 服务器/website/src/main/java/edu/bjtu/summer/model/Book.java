package edu.bjtu.summer.model;

import java.util.Date;

public class Book {

    private long book_id;
    private int book_category_id;
    private int store_id;
    private String name;
    private String outline;
    private String detail;
    private String press;
    private String publish_date;
    private String size;
    private String version;
    private String author;
    private String translator;
    private String isbn;
    private double price;
    private int pages;
    private String catalog;
    private double market_price;
    private double member_price;
    private int deal_mount;
    private int look_mount;
    private double discount;
    private String image_url;
    private int store_mount;
    private Date store_time;
    private String pack_style;
    private int is_shelf;
    private String cname;
    private String description;
    private String cata;
    private String content;

    public Book(){}

    public Book(long book_id, int book_category_id, int store_id, String name, String outline,
                String detail, String press, String publish_date, String size, String version,
                String author, String translator, String isbn, double price, int pages,
                String catalog, double market_price, double member_price, int deal_mount,
                int look_mount, double discount, String image_url, int store_mount,
                Date store_time, String pack_style, int is_shelf, String cname, String description,
                String cata, String content) {
        this.book_id = book_id;
        this.book_category_id = book_category_id;
        this.store_id = store_id;
        this.name = name;
        this.outline = outline;
        this.detail = detail;
        this.press = press;
        this.publish_date = publish_date;
        this.size = size;
        this.version = version;
        this.author = author;
        this.translator = translator;
        this.isbn = isbn;
        this.price = price;
        this.pages = pages;
        this.catalog = catalog;
        this.market_price = market_price;
        this.member_price = member_price;
        this.deal_mount = deal_mount;
        this.look_mount = look_mount;
        this.discount = discount;
        this.image_url = image_url;
        this.store_mount = store_mount;
        this.store_time = store_time;
        this.pack_style = pack_style;
        this.is_shelf = is_shelf;
        this.cname = cname;
        this.description = description;
        this.cata = cata;
        this.content = content;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public int getBook_category_id() {
        return book_category_id;
    }

    public void setBook_category_id(int book_category_id) {
        this.book_category_id = book_category_id;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getoutline() {
        return outline;
    }

    public void setoutline(String outline) {
        this.outline = outline;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public double getMarket_price() {
        return market_price;
    }

    public void setMarket_price(double market_price) {
        this.market_price = market_price;
    }

    public double getMember_price() {
        return member_price;
    }

    public void setMember_price(double member_price) {
        this.member_price = member_price;
    }

    public int getDeal_mount() {
        return deal_mount;
    }

    public void setDeal_mount(int deal_mount) {
        this.deal_mount = deal_mount;
    }

    public int getLook_mount() {
        return look_mount;
    }

    public void setLook_mount(int look_mount) {
        this.look_mount = look_mount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getStore_mount() {
        return store_mount;
    }

    public void setStore_mount(int store_mount) {
        this.store_mount = store_mount;
    }

    public Date getStore_time() {
        return store_time;
    }

    public void setStore_time(Date store_time) {
        this.store_time = store_time;
    }

    public String getPack_style() {
        return pack_style;
    }

    public void setPack_style(String pack_style) {
        this.pack_style = pack_style;
    }

    public int getIs_shelf() {
        return is_shelf;
    }

    public void setIs_shelf(int is_shelf) {
        this.is_shelf = is_shelf;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCata() {
        return cata;
    }

    public void setCata(String cata) {
        this.cata = cata;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
