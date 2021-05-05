package com.se2.ebanking.repositories;


public class DAOFactory {
    private DAOFactory(){}
        public static final DAO getDAO(String DAOType){
            switch (DAOType) {
                case "Customer":
                    return new CustomerDAO();
                case "Transaction":
                    return new TransactionDAO();
                case "Account":
                    return new AccountDAO();
                case "Loan":
                    return new LoanDAO();
                case "TransactionRate":
                    return new TransactionRateDAO();
                case "Role":
                    return new RoleDAO();
                case "Saving":
                    return new SavingDAO();
                default:
                    throw new IllegalArgumentException("This DAO type is unsupported");
            }
        }

}
