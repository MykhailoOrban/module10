package homeWork10;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

        public class FileConverter {
            public static void main(String[] args) {
                String inputFilePath = "fileUsers.txt";
                String outputFilePath = "user.json";

                try {
                    List<User> userList = readUsersFromFile(inputFilePath);
                    writeUsersToJsonFile(userList, outputFilePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            private static List<User> readUsersFromFile(String filePath) throws IOException {
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    reader.readLine();
                    Gson gson = new Gson();
                    Type userListType = new TypeToken<List<User>>() {}.getType();

                    return gson.fromJson(reader, userListType);
                }
            }

            private static void writeUsersToJsonFile(List<User> userList, String filePath) throws IOException {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String json = gson.toJson(userList);

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                    writer.write(json);
                }
            }
        }
