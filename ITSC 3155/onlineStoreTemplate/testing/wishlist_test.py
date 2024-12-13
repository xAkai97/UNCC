
######################## WISHLIST CLASS AND FUNCTIONS ##########################
class JerseyManager:
    def __init__(self):
        self.wishlist = {}  # Dictionary to store the saved jerseys

    def add_to_wishlist(self, jersey_id, jersey_info):
        """
        Add a jersey to the wishlist.

        Parameters:
            jersey_id (str or int): The ID or name of the jersey.
            jersey_info (dict): Dictionary containing any relevant information about the jersey.

        Returns:
            None
        """
        self.wishlist[jersey_id] = jersey_info

    def remove_from_wishlist(self, jersey_id):
        """
        Remove a jersey from the wishlist.

        Parameters:
            jersey_id (str or int): The ID or name of the jersey to remove.

        Returns:
            None
        """
        if jersey_id in self.wishlist:
            del self.wishlist[jersey_id]

    def display_wishlist(self):
        """
        Display the saved jerseys in the wishlist.

        Parameters:
            None

        Returns:
            None
        """
        if self.wishlist:
            print("Saved Jerseys:")
            for jersey_id, jersey_info in self.wishlist.items():
                print(f"Jersey ID: {jersey_id}")
                for key, value in jersey_info.items():
                    print(f"{key}: {value}")
                print("-------------------------")
        else:
            print("Your wishlist is empty.")


### Example use ###
if __name__ == "__main__":
    jersey_manager = JerseyManager()

    # Adding jerseys to the wishlist (data will come from form)
    jersey_manager.add_to_wishlist(1, {"Name": "Team A Jersey", "Size": "M", "Price": "$39.99"})
    jersey_manager.add_to_wishlist(2, {"Name": "Team B Jersey", "Size": "L", "Price": "$49.99"})

    # Displaying the wishlist
    jersey_manager.display_wishlist()

    # Removing a jersey from the wishlist
    jersey_manager.remove_from_wishlist(1)

    # Displaying the updated wishlist
    jersey_manager.display_wishlist()
