package homework9;

import org.apache.wicket.protocol.http.WebApplication;

public class MyWicketApplication extends WebApplication {
    public MyWicketApplication() {
    }

    @Override
    public Class getHomePage() {
        return MyWicketPage.class;
    }
}
