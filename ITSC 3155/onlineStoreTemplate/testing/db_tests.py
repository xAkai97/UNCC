import random as rand
from database.db import Database
from core.utils import dict_factory


def test_init_db(db: Database = None) -> tuple:
    """
    Tests that the database is initialized correctly.

    args:
        - db: an sqlite3 database object (optional)

    returns:
        - error_report: a tuple containing a boolean and a string, 
          where the boolean is True if the test passed and False if it failed, 
          and the string is the error report.
    """

    db = Database("database/store_records.db") if db is None else db

    if db.database_path != "database/store_records.db":
        error = f"Error in test_init_db: Database path is not correct.\n  - Actual: {db.database_path}"
        return False, error
    else:
        return True, "Database path is correct."


def test_get_inventory_exists(db: Database = None) -> tuple:
    """
    Tests that the inventory is not empty.

    args:
        - db: an sqlite3 database object (optional)

    returns:
        - error_report: a tuple containing a boolean and a string, 
          where the boolean is True if the test passed and False if it failed, 
          and the string is the error report.
    """

    db = Database("database/store_records.db") if db is None else db
    full_inventory = db.get_full_inventory()

    if len(full_inventory) == 0:
        error = f"Error in test_get_full_inventory: Full inventory is empty.\n  - Actual: {len(full_inventory)}"
        return False, error
    else:
        return True, "Full inventory is not empty."


def test_dict_factory_link(db: Database = None) -> tuple:
    """
    Tests that the row factory is linked to dict_factory.

    args:
        - db: an sqlite3 database object (optional)

    returns:
        - error_report: a tuple containing a boolean and a string,
    """
    db = Database("database/store_records.db") if db is None else db
    row_factory = db.connection.row_factory

    if row_factory != dict_factory:
        error = f"Error in test_dict_factory_link: Row factory is not linked to dict_factory.\n  - Expected: {dict_factory}\n  - Actual: {row_factory}"
        return False, error
    else:
        return True, "Row factory is linked to dict_factory."


def test_check_connection_threaded(db: Database = None) -> tuple:
    """
    Tests that the database connection is not single threaded.

    args:
        - db: an sqlite3 database object (optional)

    returns:
        - error_report: a tuple containing a boolean and a string,
    """

    db = Database("database/store_records.db") if db is None else db
    connection_is_threaded = db.connection.isolation_level is None

    if connection_is_threaded:
        error = f"Error in test_check_connection_single_thread: Connection is single threaded.\n  - Actual: {connection_is_threaded}"
        return False, error
    else:
        return True, "Connection is not single threaded."
    

def test_insert_raffle_ticket(db: Database = None) -> tuple:
    """
    Tests that user can successfully enter jersey raffle.

    args:
        - db: an sqlite3 database object (optional)

    returns:
        - error_report: a tuple containing a boolean and a string, 
          where the boolean is True if the test passed and False if it failed, 
          and the string is the error report.
    """

    db = Database("database/store_records.db") if db is None else db
    starting_raffle_count = db.current_raffle_count()

    db.insert_new_raffle_ticket("mherna62", "Bob Hernandez", "Inter Miami", 10, "XL", "Male")

    new_raffle_count = db.current_raffle_count()

    if new_raffle_count != starting_raffle_count + 1:
        error = f"Error in test_insert_raffle_ticket: Raffle tabel fails to insert user values.\n  - Actual: {(new_raffle_count)}"
        return False, error
    else:
        return True, "Successful raffle entry!"
    
def test_stock(db: Database = None) -> tuple:
    """
    Tests that the product stock amount can be set and get is correct.

    args:
        - db: an sqlite3 database object (optional)

    returns:
        - error_report: a tuple containing a boolean and a string, 
          where the boolean is True if the test passed and False if it failed, 
          and the string is the error report.
    """

    db = Database("database/store_records.db") if db is None else db
    number = rand.randint(1, 99)
    id = rand.randint(2, 4)

    db.set_item_stock(1, number)
    db.set_item_stock(id, number)

    stock1 = db.get_item_stock_by_id(1)
    stock2 = db.get_item_stock_by_id(id)

    if stock1 != stock2:
        error = f"Error in test_stock: Stock Inventory is not Working. Actual: {(stock1)}, {(stock2)}"
        return False, error
    else:
        return True, "Stock Inventory Test Pass!"

def test_add_to_wishlist(db: Database = None) -> tuple:
    """
    Tests that the product can be added to wishlist table.

    args:
        - db: an sqlite3 database object (optional)

    returns:
        - error_report: a tuple containing a boolean and a string, 
          where the boolean is True if the test passed and False if it failed, 
          and the string is the error report.
    """
    db = Database("database/store_records.db") if db is None else db

    db.add_to_wishlist("Test4", "Team C Jersey", "M", 49.99)
    db.add_to_wishlist("Test5", "Team D Jersey", "L", 49.99)

    id1 = db.get_username("Test4")
    id2 = db.get_username("Test5")

    p1 = db.get_jersey_price(4)
    p2 = db.get_jersey_price(5)

    if id1 != id2:
        if p1 == p2:
            return True, "Wishlist Test Passed!"
    else:
        error = f"Error in test_add_to_wishlist: wishlist is not working. Actual: {(id1)}, {(p2)}, {(id1)}, {(p2)}"
        return False, error
    
def test_remove_from_wishlist(db: Database = None) -> tuple:
    """
    Tests that the product can be removed to wishlist table.

    args:
        - db: an sqlite3 database object (optional)

    returns:
        - error_report: a tuple containing a boolean and a string, 
          where the boolean is True if the test passed and False if it failed, 
          and the string is the error report.
    """
    db = Database("database/store_records.db") if db is None else db

    db.remove_from_wishlist(4)
    db.remove_from_wishlist(5)
    id4 = db.get_jersey_id(4)
    id5 = db.get_jersey_id(5)


    if id4 is None and id5 is None:
        return True, "Test Pass!"
    else:
        error = f"Error in test_remove_from_wishlist: Wishlist table slot is not empty. Actual: {(id)}"
        return False, error

def test_display_wishlist(db: Database = None) -> tuple:
    """
    Tests that wishlist table is being displayed

    args:
        - db: an sqlite3 database object (optional)

    returns:
        - error_report: a tuple containing a boolean and a string, 
          where the boolean is True if the test passed and False if it failed, 
          and the string is the error report.
    """
    db = Database("database/store_records.db") if db is None else db

    ds = db.display_wishlist()

    if ds != None:
        return True, "Display Wishlist Test Pass!"
    else:
        error = f"Error in test_display_wishlist: Wishlist table error. Actual: {(ds)}"
        return False, error

def test_insert_wishlist_item(db: Database = None) -> tuple:
    """
    Tests that user can add a new wishlist item.

    args:
        - db: an sqlite3 database object (optional)

    returns:
        - error_report: a tuple containing a boolean and a string, 
          where the boolean is True if the test passed and False if it failed, 
          and the string is the error report.
    """

    db = Database("database/store_records.db") if db is None else db
    starting_wishlist_length = len(db.display_wishlist())

    db.add_to_wishlist("mherna62", "1")

    new_wishlist_length = len(db.display_wishlist())

    if starting_wishlist_length != new_wishlist_length - 1:
        error = f"Error in test_insert_wishlist_item: Wishlist Item Not Added.\n  - Actual: {(new_wishlist_length)}"
        return False, error
    else:
        return True, "Successful Wishlist Entry!!!"
    

