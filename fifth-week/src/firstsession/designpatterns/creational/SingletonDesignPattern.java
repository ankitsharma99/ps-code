package firstsession.designpatterns.creational;


// Eager Initialization:
class DBConnectionEager {
    private static DBConnectionEager dbConnectionEager = new DBConnectionEager();
    private DBConnectionEager() {}

    public static DBConnectionEager getInstance() {
        return dbConnectionEager;
    }
}

// Lazy:
class DBConnectionLazy {
    private static DBConnectionLazy dbConnectionLazy;
    private DBConnectionLazy () {}

    public static DBConnectionLazy getInstance() {
        if(dbConnectionLazy == null) {
            dbConnectionLazy = new DBConnectionLazy();
        }
        return dbConnectionLazy;
    }
}

class DBConnectionSynchronized {
    private static DBConnectionSynchronized dbConnectionSynchronized;
    private DBConnectionSynchronized() {}

    synchronized public static DBConnectionSynchronized getInstance() {
        if(dbConnectionSynchronized == null) {
            dbConnectionSynchronized = new DBConnectionSynchronized();
        }
        return dbConnectionSynchronized;
    }
}

class DBConnectionDoubleLocking {
    private static DBConnectionDoubleLocking dbConnectionDoubleLocking;
    private DBConnectionDoubleLocking () {}

    public static DBConnectionDoubleLocking getInstance() {
        if(dbConnectionDoubleLocking == null) {
            synchronized (DBConnectionDoubleLocking.class) {
                if(dbConnectionDoubleLocking == null) {
                    dbConnectionDoubleLocking = new DBConnectionDoubleLocking();
                }
            }
        }
        return dbConnectionDoubleLocking;
    }
}
public class SingletonDesignPattern {
    // Eager:
    DBConnectionEager dbConnectionEager = DBConnectionEager.getInstance();  // gets initialized when class loads
    // Lazy: (problematic in multithreading)
    DBConnectionLazy dbConnectionLazy = DBConnectionLazy.getInstance();     // gets initialized only when getInstance is called

    // Synchronized Method (expensive locking):
    DBConnectionSynchronized dbConnectionSynchronized = DBConnectionSynchronized.getInstance();


    // Double Locking (Double-checking of lock):
    DBConnectionDoubleLocking dbConnectionDoubleLocking = DBConnectionDoubleLocking.getInstance();

}
