package consts;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ConfigEnum {
    BASE_URL("/baseUrl"),
    FILE_PATH("settings.json");
    public final String label;
}
