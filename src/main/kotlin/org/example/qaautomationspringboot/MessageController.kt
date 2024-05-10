package org.example.qaautomationspringboot

import org.springframework.web.bind.annotation.*

@RestController
class MessageController(val service: MessageService) {
    val list = mutableListOf<Message>(
            Message("1", "Hello!"),
            Message("2", "Bonjour!"),
            Message("3", "Privet!")
    )

    @GetMapping("/")
    fun index(): List<Message> = service.findMessages()

    @GetMapping("/{id}")
    fun index(@PathVariable id: String): List<Message> =
            service.findMessageById(id)

    @GetMapping("/list")
    fun list() = this.list

    @GetMapping("/mutablelist")
    fun mutable() = list

    @PostMapping("/")
    fun post(@RequestBody message: Message) {
        service.save(message)
    }
}
