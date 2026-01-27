package ooad.creationalpattern.morningclass.factorymethod.extendfeature;

import ooad.creationalpattern.morningclass.factorymethod.ConnectionCreator;
import ooad.creationalpattern.morningclass.factorymethod.ConnectionProduct;

public class EmailSenderCreator
        extends ConnectionCreator {
    @Override
    public ConnectionProduct getInstance() {
        // return object of email sender
        //....
        return null;
    }
}
