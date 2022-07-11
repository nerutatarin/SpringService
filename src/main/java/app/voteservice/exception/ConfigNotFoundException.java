package app.voteservice.exception;

public class ConfigNotFoundException extends VoteServiceException{
    public ConfigNotFoundException(String message) {
        super(message);
    }
}
