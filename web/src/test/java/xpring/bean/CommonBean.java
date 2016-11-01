package xpring.bean;

/**
 * Created by yanricheng on 16-10-25.
 */
public class CommonBean
{
    private String commonName;

    public void setCommonName(String commonName)
    {
        System.out.println("设置属性");
        this.commonName = commonName;
    }

    public void initMethod()
    {
        System.out.println("属性设置后InitializingBean init");
    }
}
