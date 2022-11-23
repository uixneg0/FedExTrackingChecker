package FedExTrackerChecker.entities;

import lombok.Getter;

@Getter
public class OAuthJson {
    public String grant_type;
    public String client_id;
    public String client_secret;
    public String child_Key;
    public String child_secret;
}
