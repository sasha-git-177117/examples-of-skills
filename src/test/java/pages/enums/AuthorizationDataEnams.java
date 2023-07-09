package pages.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AuthorizationDataEnams {
    PASSWORD("Choose Password"),
    EMAIL("Your email"),
    DOMAIN("Domain");
    public final String label;
}

