package handlers;

import common.Type;

/**
 * //TODO - Implement approval implementation for President level
 */
public class President extends Approver{
    @Override
    public void approve(int id, double cost, Type type) {
    	if (canApprove(id, cost, type)) {
            System.out.println("President approved purchase with id " + id + " that costs " + cost);
            return;
        }

        System.out.println("Purchase with id " + id + " is on the highest position.");
        next.approve(id, cost, type);
    }

    @Override
    protected boolean canApprove(int id, double cost, Type type) {
    	boolean result = false;

        if ((type == Type.CONSUMABLES && cost <= 1000) || (type == Type.CLERICAL && cost <= 2000) || (type == Type.GADGETS && cost <= 3000) || (type == Type.GAMING && cost <= 5000) || (type == Type.PC && cost <= 8000)) {
            result = true;
            return result;
        } else {
            result = false;
            return result;
        }
    }
}
