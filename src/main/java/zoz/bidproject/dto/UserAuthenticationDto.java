
package zoz.bidproject.dto;


import javax.validation.constraints.NotBlank;


import com.sun.istack.NotNull;

public class UserAuthenticationDto {
	
	@NotBlank(message = "Username Not Should be blank ")
	@NotNull
	private String username;
	@NotBlank(message = "Password Not Should be blank ")
	@NotNull
	private String password;
	
	public UserAuthenticationDto() {
		
	}
	
	public UserAuthenticationDto(String username, String password) {

		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
