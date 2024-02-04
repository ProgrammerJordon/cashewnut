package cashewnut.biz.test;

import lombok.Data;

@Data
public class TestVO {

    private String title;
    private String content;

    public TestVO() {}

    public TestVO(String title, String content) {
        this.title = title;
        this.content = content;
    }



}
