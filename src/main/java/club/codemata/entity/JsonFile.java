package club.codemata.entity;

import com.alibaba.fastjson.JSONObject;

public class JsonFile {
    private JSONObject json;

    public JSONObject getContent() {
        return this.json;
    }

    public boolean setValue(String key, Object value) {
        return false;
    }
}
