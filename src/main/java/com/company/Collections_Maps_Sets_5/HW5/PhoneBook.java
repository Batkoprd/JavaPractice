package main.java.com.company.Collections_Maps_Sets_5.HW5;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class PhoneBook {
    HashMap<String, TreeSet<String>> record;

    public PhoneBook() {
        this.record = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        if (!record.containsKey(name)) {
            record.put(name, new TreeSet<>());
        }
        record.get(name).add(phoneNumber);
    }

    public Set<String> getAllPhoneNumbers(String name) {
        return record.get(name);
    }

    public Set<String> getAllNames() {
        return record.keySet();
    }
}
