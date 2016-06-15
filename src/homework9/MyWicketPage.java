package homework9;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

/*
 * This should work basically if you deploy it, should send out a normal message on the webpage.
 * I didnt try anything major because I am unable to deploy the page for some reason.
 * Logically, it should work once deployed.
 * 
 *  -Meelis
 */


public class MyWicketPage extends WebPage {
    public MyWicketPage() {
        add(new Label("message", "Not hello!"));
    }
}