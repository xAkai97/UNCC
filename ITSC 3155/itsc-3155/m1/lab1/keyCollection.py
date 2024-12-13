from hashStudentID import key_from_student_ids


class StudentIDManager:
    """
    A class that holds a dictionary of student IDs and has special methods to manage and export the data.

    attributes:
        - student_ids: a dictionary of student IDs (key: student ID, value: list of first and last name strings)
    """

    def __init__(self):
        self.student_ids = {"0321958322": ["Bjarne", "Stroustrup"],
                            "9780262033848": ["Thomas", "Cormen"],
                            "9780131103627": ["Brian", "Kernighan"],
                            "0136042597": ["Stuart", "Russell"]}
        
    def print_id_count(self):
        """
        Prints the number of student IDs in the global student_ids dictionary.
        """
        print(f"There currently are {len(self.student_ids)} student IDs that can be exported.")


    def add_student_id_record(self, student_id: int, first_name: str, last_name: str) -> None:
        """
        Adds a student ID record to the global student_ids dictionary.

        modifies:
            - self.student_ids: adds a new key-value pair to the dictionary
        """
        # TODO 5: Use the proper dictionary method to add a new key-value pair to the dictionary
        # - you must convert the student ID to a string
        # - your value should be a list of the first and last name strings
        self.student_ids[str(student_id)] = [first_name, last_name]

    def calculate_all_keys(self) -> None:
        """
        Calculates all possible keys from the student IDs in the global student_ids dictionary.

        - returns: a list of all possible keys and their corresponding student names
        """
        keys = []

        for student_id_A in self.student_ids:
            for student_id_B in self.student_ids:
                if student_id_A == student_id_B:
                    continue
                # TODO 6: Grab the names for each student ID and store them in their correct variables
                # - `full_name_A` should be the first and last name of student A
                # - `full_name_B` should be the first and last name of student B
                # - put a space between the first and last name in your full_name variables
                # - remember that the values in the dictionary are lists and must be indexed to get the names
                full_name_A = ' '.join(self.student_ids)
                full_name_B = ' '.join(self.student_ids)
                
                # TODO 7: Calculate the key and store it in a variable called `key`
                # - use the key_from_student_ids() function

                key = key_from_student_ids(student_id_A, student_id_B)

                # TODO 8: Create a list called `key_info` to store all information for this key
                # - the first element should be the key
                # - the second element should be the full name of student A
                # - the third element should be the full name of student B
                key_info = [key, full_name_A, full_name_B]

                # TODO 9: Append the `key_info` list to the `keys` list
                keys.append(key_info)

        return keys

    def write_all_ids_to_file(self, filename: str) -> None:
        """
        Writes all student ID keys and values to a file.

        modifies:
            - filename: a file containing all student ID keys and values
        """
        all_keys = self.calculate_all_keys()

        with open(filename, "w") as file:
            for key in all_keys:
                file.write(f"{key[0]}: {key[1]} and {key[2]}\n")

        print(f"Successfully wrote {len(all_keys)} keys to {filename}!")


def main():
    manager = StudentIDManager()
    manager.print_id_count()
    student_one = ("1234567890", "John", "Doe")
    student_two = ("0987654321", "Jane", "Doe")
    # TODO 10: Add the new students' information using the correct method in the manager object
    manager.add_student_id_record(*student_one)
    manager.add_student_id_record(*student_two)
    # TODO 11: Write all keys to the file "keys.txt" using the correct method in the manager object
    manager.write_all_ids_to_file("keys.txt")


if __name__ == "__main__":
    main()
