package handlers;

import common.Type;


/**
 * //TODO - Implement approval implementation for VicePresident level
 */
public class VicePresident extends Approver{
    @Override
    public void approve(int id, double cost, Type type) {
    	if (canApprove(id, cost, type)) {
            System.out.println("Vice president approved purchase with id " + id + " that costs " + cost);
            return;
        }

        System.out.println("Purchase with id " + id + " needs approval from higher position than Vice president.");
        next.approve(id, cost, type);
    }

    @Override
    protected boolean canApprove(int id, double cost, Type type) {
    	boolean result = false;

        if ((type == Type.CONSUMABLES && cost <= 700) || (type == Type.CLERICAL && cost <= 1500) || (type == Type.GADGETS && cost <= 2000) || (type == Type.GAMING && cost <= 4500) || (type == Type.PC && cost <= 6500)) {
            result = true;
            return result;
        } else {
            result = false;
            return result;
        }
    }
}
