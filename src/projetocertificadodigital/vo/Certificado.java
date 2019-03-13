package projetocertificadodigital.vo;

public class Certificado {
	
        private int codigoIcp;
	private String email;
	private String endereco;

    public Certificado() {
    }

    public Certificado(int codigoIcp, String email, String endereco) {
        this.codigoIcp = codigoIcp;
        this.email = email;
        this.endereco = endereco;
    }

    public int getCodigoIcp() {
        return codigoIcp;
    }

    public void setCodigoIcp(int codigoIcp) {
        this.codigoIcp = codigoIcp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    
}
