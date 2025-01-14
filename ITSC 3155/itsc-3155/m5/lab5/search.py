from utils import *
from selenium import webdriver
from selenium.webdriver.common.by import By


def scrape_book_titles(driver: webdriver.Chrome, url: str) -> list:
    """
    Scrapes the book titles from the books to scrape website.

    args:
        - driver: a selenium webdriver object
        - url: the url of the current page within the website

    returns:
        - a list of book titles (strings)    
    """

    book_titles = []
    books = []

    # TODO 5: Use the driver to get the url
    driver.get(url)
    
    # TODO 6: Get the list of books from the current page using the driver
    # - Save the list of books to the variable `books`
    # - See the README for documentation on locating elements in Selenium
    # - the group of book titles comes from the class "product_pod"
    books = driver.find_elements(By.CLASS_NAME, "product_pod")

    # TODO 7: Loop through the list of books and get the title of each book
    # - Append the title of each book to the list `book_titles`
    # - Each title is nested in a tag "h3" and a tag "a" and title is the attribute "title"
    for book in books:
        title_element = book.find_element(By.TAG_NAME, "h3").find_element(By.TAG_NAME, "a")
        title = title_element.get_attribute("title")
        book_titles.append(title)

    return book_titles


def main():
    driver = create_driver(get_chromedriver_path())
    erase_file("titles.txt")
    route_counts = {}
    for route in ROUTES:
        url = build_books_to_scrape_url(route)
        book_titles = scrape_book_titles(driver, url)
        route_counts[route] = len(book_titles)
        write_titles_to_file("titles.txt", book_titles)
    driver.quit()

    index_page = "./docker/index.html"
    if check_html_content_length(index_page):
        erase_file(index_page)
        write_html_header(index_page)
    
    write_lines_to_html_list(index_page, open("titles.txt", 'r').readlines())


    write_smallest_and_largest_books(
        "titles.txt", sort_dict_by_value(route_counts))


if __name__ == '__main__':
    main()
