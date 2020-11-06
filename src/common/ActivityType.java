package common;

/**
 * @author Hujf
 * @title: ActivityType
 * @date 2020/9/18 0018下午 2:49
 * @description: TODO
 */
public enum ActivityType {
    /**
     * 活动类型
     */
    ZeroShopping("1", "0.1元购"),
    oneShopping("2", "1元好货"),
    BrandDiscount("3", "大牌1折起");

    ActivityType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    private String code;
    private String desc;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static String getDescByCode(String code) {
        ActivityType a [] =ActivityType.values();
        for (ActivityType e : a) {
            System.out.println(e.desc);
        }
        return null;
    }
}
