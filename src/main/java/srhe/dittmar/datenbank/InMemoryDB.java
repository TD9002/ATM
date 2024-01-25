package srhe.dittmar.datenbank;

import srhe.dittmar.account.Account;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDB {
        private List<Account> accountList;

        public InMemoryDB() {
            accountList = new ArrayList<>();
            accountList.add(new Account(1,"Frank",1111,-660));
            accountList.add(new Account(2,"Till", 2222, 10_000));
            accountList.add(new Account(3,"Tilman",3333,50));
            accountList.add(new Account(4,"Jana",4444,5000));
            accountList.add(new Account(5,"Jonathan",5555,50_000_000));

        }

    // TODO: 25.01.2024 über copies nachlesen, evtl nur copies zurückgeben 
        public List<Account> getAccountList() {
            return accountList;
        }

        public boolean addAccount(Account account){
          return accountList.add(account);
        }

        public boolean deleteAccount(int accountNumber){
            for (int i = 0; i <accountList.size() ; i++) {
                if (accountNumber == accountList.get(i).getAccountNumber()){
                    accountList.remove(i);
                    return true;
                }
            }
            return false;
        }

        public boolean updateAccount(int accountNumber , Account account){
            deleteAccount(accountNumber);
            return addAccount(account);
        }

    }



