import org.aeonbits.owner.Config;

@Config.Sources("classpath:base.properties")
public interface SelenideConfig extends Config {

    @DefaultValue("Chrome")

    @Key("browserName")
    String browserName();

    @Key("baseUrl")
    String baseUrl();

    @Key("resolution")
    String resolution();

}