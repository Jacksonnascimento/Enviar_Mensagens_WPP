from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time

# Inicialize o driver do navegador (nesse caso, estou usando o ChromeDriver)
driver = webdriver.Chrome()  # Você pode usar outro driver, como o Firefox GeckoDriver

# Abra o WhatsApp Web
driver.get("https://web.whatsapp.com/")
print("Escaneie o código QR no WhatsApp Web e pressione Enter aqui.")
input("Pressione Enter após escanear o código QR...")

# Espere alguns segundos para a página carregar completamente
time.sleep(5)

# Encontre o campo de pesquisa e digite o nome ou número do contato
campo_pesquisa = driver.find_element(By.CSS_SELECTOR, 'div[contenteditable="true"]')
contato = "Nome ou número do contato"  # Substitua pelo nome ou número do contato desejado
campo_pesquisa.click()
campo_pesquisa.send_keys(contato)
time.sleep(2)  # Aguarde um momento para a pesquisa ser concluída

# Encontre o chat do contato e abra-o
chat_contato = driver.find_element(By.CSS_SELECTOR, f'span[title="{contato}"]')
chat_contato.click()

# Espere mais alguns segundos para a conversa carregar
time.sleep(3)

# Encontre o campo de mensagem e digite a mensagem desejada
campo_mensagem = driver.find_element(By.CSS_SELECTOR, 'div[data-tab="6"]')
mensagem = "Sua mensagem aqui!"  # Substitua pela mensagem que deseja enviar
campo_mensagem.click()
campo_mensagem.send_keys(mensagem)

# Envie a mensagem pressionando Enter
campo_mensagem.send_keys(Keys.ENTER)

# Aguarde alguns segundos antes de fechar o navegador
time.sleep(3)

# Feche o navegador
driver.quit()
print("Mensagem enviada com sucesso!")

exit()