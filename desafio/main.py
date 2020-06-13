import requests
import json
import hashlib

def requisitar():
  token = "__MINHA_KEY__"
  url = "https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token={}".format(token)
  response = requests.get(url).json()
  return response

def decifrar(string, casas):
  string = string.lower()
  resultado = ""
  for c in string:
    if c not in [" ",".",";"]:
      charv = ord(c)
      if charv < casas + 97:
        charv += 26
      resultado += chr(charv - casas)
    else :
      resultado += c
  return resultado

def escrever(jsonstring):
  with open("answer.json", "w") as file:
    json_object = json.dumps(jsonstring, indent = 2)
    file.write(json_object)
  file.close()

def gerarSHA1(decifrado):
  return hashlib.sha1(decifrado.encode()).hexdigest()

def submeter():
  token = "__MINHA_KEY__"
  url = "https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token={}".format(token)
  file = {
    "answer" : open("answer.json", "rb")
  }
  r = requests.post(url, files=file)
  print(r.status_code)

def main_pipeline():
  response = requisitar()
  escrever(response)
  cifrado,numero_casas = response["cifrado"],int(response["numero_casas"])
  decifrado = decifrar(cifrado,numero_casas)
  response["decifrado"] = decifrado
  escrever(response)
  resumo_criptografico = gerarSHA1(decifrado)
  response["resumo_criptografico"] = resumo_criptografico
  escrever(response)
  submeter()


if __name__ == "__main__":
  main_pipeline()
  
