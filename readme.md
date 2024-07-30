## Projeto de Estudo: Arquitetura Orientada a Eventos

### Visão Geral

Este projeto de estudo foi desenvolvido para explorar a arquitetura orientada a eventos, uma abordagem onde os serviços comunicam-se entre si através de eventos disparados e consumidos. O objetivo principal foi implementar um fluxo de venda utilizando micro serviços, tópicos e consumidores para realizar ações automatizadas.

### Componentes

1. **Micro serviço de PDV (Ponto de Venda)**: Responsável por registrar as vendas e enviar eventos para um tópico específico.
2. **Tópico de Eventos**: Recebe os eventos do micro serviço de PDV e, em seguida, dispara ações conforme necessário.
3. **Serviço de Envio de Email**: Consome os eventos do tópico e envia emails de confirmação de venda para os clientes.
4. **Serviço de Pagamento**: Também consome os eventos do tópico, atualiza o status dos pedidos no sistema e realiza o processamento de pagamento.

### Fluxo do Sistema

1. O **micro serviço de PDV** registra uma venda e publica um evento no tópico.
2. O **tópico de eventos** recebe o evento.
3. O **serviço de envio de email** consome o evento do tópico e envia um email de confirmação de venda ao cliente.
4. O **serviço de pagamento** consome o evento do tópico, processa o pagamento e atualiza o status do pedido no sistema.

### Tecnologias Utilizadas

- **Kafka**: Utilizado como sistema de mensageria para gerenciar os tópicos de eventos.
- **Spring Boot**: Utilizado para desenvolver os micro serviços.
- **Java**: Linguagem de programação utilizada no desenvolvimento dos micro serviços.
- **Docker**: Utilizado para orquestrar os containers dos micro serviços e do Kafka.

### Conclusão

Este projeto proporcionou uma compreensão prática sobre a arquitetura orientada a eventos, demonstrando como é possível desacoplar os serviços e torná-los mais escaláveis e resilientes. Através do uso de Kafka, foi possível gerenciar a comunicação entre serviços de maneira eficiente e confiável, garantindo que as ações sejam executadas de forma assíncrona e independente.

### Próximos Passos

- Adicionar novos serviços consumidores para expandir a funcionalidade.
- Implementar mecanismos de monitoramento e logging para melhor gestão dos eventos.
- Explorar outras tecnologias de mensageria para comparação e melhoria contínua do sistema.

---

Este projeto está disponível para consulta e contribuições no meu repositório do GitHub. Sinta-se à vontade para explorar, sugerir melhorias ou utilizá-lo como base para seus próprios estudos sobre arquitetura orientada a eventos.

![video](https://www.linkedin.com/feed/update/urn:li:activity:7220968142200537090/?originTrackingId=QokrwLfHR%2ByruDKJAdSY0w%3D%3D)

![Demonstração](https://i.imgur.com/O6B6BTW.gif)
