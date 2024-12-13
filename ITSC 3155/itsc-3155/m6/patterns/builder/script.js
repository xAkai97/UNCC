class Student {
    constructor({ first_name = '', last_name = '', major = '', gpa = 0, description = '' }) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.major = major;
        this.gpa = gpa;
        this.description = description;
    }

    // Get methods for the Student class
    getFirstName() {
        return this.first_name;
    }

    getLastName() {
        return this.last_name;
    }

    // TODO 1: Add getMajor(), getGPA(), getDescription(), and getFullName() methods
    getMajor() {
        return this.major;
    }

    getGPA() {
        return this.gpa;
    }

    getDescription() {
        return this.description;
    }

     getFullName() {
        return this.first_name + this.last_name;
    }
}

class StudentBuilder {
    // takes in no arguments, but creates a new Student object with default values
    constructor() {
        this.student = new Student({});
    }

    // Method to set the name of the student
    setFirstName(first_name) {
        this.student.first_name = first_name;
        return this;
    }

    // Method to set the last name of the student
    setLastName(last_name) {
        this.student.last_name = last_name;
        return this;
    }

    // TODO 2: Add setMajor(), setGPA(), and setDescription() methods
    setMajor(major) {
        this.student.major = major;
        return this;
    }    
    
    setGPA(gpa) {
        this.student.gpa = gpa;
        return this;
    }
    
    setDescription(description) {
        this.student.description = description;
        return this;
    }

    // Method to return the student object
    build() {
        return this.student;
    }
}

function writeStudentProfilePicture(fullName) {
    // create a new img element
    const img = document.createElement("img");
    // set the src attribute of the img element
    img.src = "./imgs/" + fullName + ".jpeg";
    // set the alt attribute of the img element
    img.alt = fullName;
    // set the class attribute of the img element
    img.className = "profile-picture";

    // return the img element to be appended to the DOM
    return img;
}

function writeStudentHeader(first_name, last_name) {
    // create a new h1 element
    const h1 = document.createElement("h1");
    // set the text content of the h1 element
    h1.textContent = first_name + " " + last_name;

    // return the h1 element to be appended to the DOM
    return h1;
}

function writeStudentProfile(description) {

    // create a new div element
    const div = document.createElement("div");
    // set the class attribute of the div element
    div.className = "student-profile";

    // create a new p element
    const p = document.createElement("p");
    // set the text content of the p element
    p.textContent = description;

    // append p elements to the div element
    div.appendChild(p);

    // return the div element
    return div;
}

// TODO 3: Add the writeStudentInfo(major, gpa) { ... } function and the writeStudent(student) { ... } function

function writeStudentInfo(major, gpa) {
    const div = document.createElement('div');
    div.textContent = `Major: ${major}, GPA: ${gpa}`;
    return div;
}

function writeStudent(student) {
    const img = writeStudentProfilePicture(student.getFullName());
    const h1 = writeStudentHeader(student.getFirstName(), student.getLastName());
    const div = writeStudentProfile(student.getDescription());
    const info = writeStudentInfo(student.getMajor(), student.getGPA());
    
    document.body.appendChild(img);
    document.body.appendChild(h1);
    document.body.appendChild(div);
    document.body.appendChild(info);
}

function buildPage() {
    const studentBuilder = new StudentBuilder();

    // TODO 4: Replace the default information here with your own information or that of an imaginary student
    studentBuilder
        .setFirstName("Derek")
        .setLastName("Wang")
        .setMajor("Computer Science")
        .setGPA(3.7)
        .setDescription("Derek is a student at UNCC, where he learns courses in computer science. He loves reading novels on online.")

    // build the student object
    const student = studentBuilder.build();

    // write the student to the DOM
    document.body.appendChild(writeStudent(student));
}

window.onload = buildPage;