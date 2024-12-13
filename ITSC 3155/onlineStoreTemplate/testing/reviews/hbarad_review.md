# Testing Review

## Tests Reviewed

- **Test Source File:** [tests/auth_tests.py](../../tests/auth_tests.py)
  - **Test Function Name:** `test_hash_password_generates_salt`
    - **Date Reviewed:** 08/03/2023
    - **Comments:**
      - The test verifies that the 'hash_password' function generates a salt when 
         one is not provided
      - It checks if the 'salt' returned by the function is not None
      - The test is well-implemented and valuable to ensure the salt generation 
        functionality is working correctly.

        
- **Test Source File:** [tests/wishlist-test.py](../../tests/wishlist-test.py)
  - **Test Function Name:** `add_to_wishlist`
    - **Date Reviewed:** 08/03/2023
    - **Comments:**
      - The 'add_to_wishlist' function adds a jersey to the wishlist with the 
         provided 'jersey_id' and 'jersey_info'.
      - It stores the jersey information in the 'wishlist' dictionary with the 
        'jersey_id' as the key. 
      - The implementation seems correct, and it allows for adding jerseys to the 
        wishlist.


