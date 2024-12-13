import requests


def indeed_request():
    # TODO 2: Put the code from the Postman steps of the lab here.
    # - Make sure you used the correct URL
    # - Also, erase any unnecessary code like the import statement
    url = "https://www.indeed.com/jobs?q=Software Engineer&l=Charlotte"

    payload = {}
    headers = {
    'Cookie': '__cf_bm=IKHfyNcOzyp_2.D2ITr6OrquKdnDJFTahGzIXL4S7Ck-1687912123-0-AWFrCYWfLJspXyHIcasTKmryQE0YdV4IbU+GiLf7JDxCvbG2WFQNTf3Mm9hMfVygOFccniNQVUIaLbRrWZPR4oQ='
    }

    response = requests.request("GET", url, headers=headers, data=payload)

    print(response.text)

if __name__ == '__main__':
    indeed_request()
