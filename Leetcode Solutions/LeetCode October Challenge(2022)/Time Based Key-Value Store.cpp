class TimeMap {
public:
    unordered_map<string,map<int,string>>m;
    TimeMap() {   
    }
    void set(string key, string value, int timestamp) {
        m[key][timestamp]=value;
    }
    string get(string key, int timestamp) {
        auto it=m[key].upper_bound(timestamp);
        if(it==m[key].begin())return "";
        it--;
        return it->second;
    }
};