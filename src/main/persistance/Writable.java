package persistance;

import org.json.JSONObject;

// Referenced from CPSC 210 content
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// Interface for all products that can be returned as JSON object
public interface Writable {

    // EFFECTS: return this as JSON object
    JSONObject toJson();
}
