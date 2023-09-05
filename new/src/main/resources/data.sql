-- Insert test data into Student table
INSERT INTO Student (student_id, name, gender) VALUES (1, 'Anna', 'Female');
INSERT INTO Student (student_id, name, gender) VALUES (2, 'John', 'Male');
INSERT INTO Student (student_id, name, gender) VALUES (3, 'Alex', 'Other');

-- Insert test data into Auth table
INSERT INTO Auth (student_id, username, password) VALUES (1, 'anna123', 'password1');
INSERT INTO Auth (student_id, username, password) VALUES (2, 'john123', 'password2');
INSERT INTO Auth (student_id, username, password) VALUES (3, 'alex123', 'password3');

-- Insert test data into Pii table
INSERT INTO Pii (pii_id, student_id, personnummer, phone_number, biometric_data) VALUES (1, 1, '860101-0101', '070-1234567', NULL);
INSERT INTO Pii (pii_id, student_id, personnummer, phone_number, biometric_data) VALUES (2, 2, '900202-0202', '071-2345678', NULL);
INSERT INTO Pii (pii_id, student_id, personnummer, phone_number, biometric_data) VALUES (3, 3, '950303-0303', '072-3456789', NULL);

-- Insert test data into HealthRecord table
INSERT INTO HealthRecord (record_id, student_id, medical_record) VALUES (1, 1, 'No known allergies.');
INSERT INTO HealthRecord (record_id, student_id, medical_record) VALUES (2, 2, 'Lactose intolerant.');
INSERT INTO HealthRecord (record_id, student_id, medical_record) VALUES (3, 3, 'Asthma.');

-- Insert test data into Course table
INSERT INTO Course (course_id, course_name) VALUES (1, 'Mathematics');
INSERT INTO Course (course_id, course_name) VALUES (2, 'History');
INSERT INTO Course (course_id, course_name) VALUES (3, 'Physics');

-- Insert test data into grade table
INSERT INTO grade (grade_id, student_id, course_id, grade) VALUES (1, 1, 1, 'A');
INSERT INTO grade (grade_id, student_id, course_id, grade) VALUES (2, 2, 2, 'B');
INSERT INTO grade (grade_id, student_id, course_id, grade) VALUES (3, 3, 3, 'C');

-- Insert test data into Activity table
INSERT INTO Activity (activity_id, activity_name, student_id) VALUES (1, 'Chess Club', 1);
INSERT INTO Activity (activity_id, activity_name, student_id) VALUES (2, 'Debate Club', 2);
INSERT INTO Activity (activity_id, activity_name, student_id) VALUES (3, 'Robotics Club', 3);
