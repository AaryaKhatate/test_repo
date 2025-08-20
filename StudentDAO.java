import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.FindIterable;

public class StudentDAO {
    private MongoCollection<Document> collection;

    public StudentDAO() {
        MongoDatabase database = MongoDBConnection.getDatabase();
        collection = database.getCollection("students");
    }

    // Insert student
    public void addStudent(Student student) {
        Document doc = new Document("name", student.getName())
                .append("email", student.getEmail())
                .append("password", student.getPassword());
        collection.insertOne(doc);
        System.out.println("Student added: " + student.getName());
    }

    // View all students
    public void listStudents() {
        FindIterable<Document> students = collection.find();
        for (Document doc : students) {
            System.out.println(doc.toJson());
        }
    }
}
