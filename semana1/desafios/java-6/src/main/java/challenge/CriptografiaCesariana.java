package challenge;

public class CriptografiaCesariana implements Criptografia {

  @Override
  public String criptografar(String texto) {

    if (texto.isEmpty()) {
      throw new IllegalArgumentException();
    }

    try {
      StringBuilder criptografado = new StringBuilder();
      texto = texto.toLowerCase();
      int ncasas = 3;
      for (int char_index = 0; char_index < texto.length(); char_index++) {
        char charletter = texto.charAt(char_index);
        int charint = (int) charletter;
        if (charint >= 97 && charint <= 122) {
          if (charint + ncasas > 122) {
            charint -= 26;
          }
          criptografado.append((char) (charint + ncasas));
        } else {
          criptografado.append(charletter);
        }
      }
      return criptografado.toString();
    } catch (NullPointerException e) {
      throw new NullPointerException();
    }

  }

  @Override
  public String descriptografar(String texto) {

    if (texto.isEmpty()) {
      throw new IllegalArgumentException();
    }
    try {
      StringBuilder descriptografado = new StringBuilder();
      texto = texto.toLowerCase();
      int ncasas = 3;
      for (int char_index = 0; char_index < texto.length(); char_index++) {
        char charletter = texto.charAt(char_index);
        int charint = (int) charletter;
        if (charint >= 97 && charint <= 122) {
          if (charint < ncasas + 97) {
            charint += 26;
          }
          descriptografado.append((char) (charint - ncasas));
        } else {
          descriptografado.append(charletter);
        }

      }
      return descriptografado.toString();
    } catch (NullPointerException error) {
      throw new NullPointerException();
    }

  }
}
