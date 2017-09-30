#include <iostream>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <stdlib.h>
#include <unistd.h>
#include <netdb.h>

#define BUFF_SIZE 64
int main()
{
	int client;
	int portNum = 1500; 
	char buffer[bufsize];
	char* ip = "127.0.0.1";

	struct sockaddr_in server_addr;

	if ((client = socket(AF_INET, SOCK_STREAM, 0)) < 0) 
	{
		std::cerr << "\nError establishing socket..." << std::endl;
		exit(1);
	}

	std::cout << "\n=> Socket client has been created..." << std::endl;
    
	server_addr.sin_family = AF_INET;
	server_addr.sin_port = htons(portNum);


	if (connect(client,(struct sockaddr *)&server_addr, sizeof(server_addr)) == 0)
		std::cout << "=> Connection to the server port number: " << portNum << std::endl;


	std::cout << "=> Awaiting confirmation from the server..." << std::endl; //line 40
	recv(client, buffer, BUFF_SIZE, 0);
	std::cout << "=> Connection confirmed, you are good to go...";

	std::cout << "\n\n=> Enter # to end the connection\n" << std::endl;

	// Once it reaches here, the client can send a message first.

	do {
		std::cout << "Client: ";
		do {
			std::cin >> buffer;
			send(client, buffer, BUFF_SIZE, 0);
			if (*buffer == '#') {
				send(client, buffer, BUFF_SIZE, 0);
				*buffer = '*';
				isExit = true;
			}
		} while (*buffer != 42);

		std::cout << "Server: ";
		do {
			recv(client, buffer, BUFF_SIZE, 0);
			std::cout << buffer << " ";
			if (*buffer == '#') {
				*buffer = '*';
				isExit = true;
			}

		} while (*buffer != 42);
		std::cout << std::endl;

	} while (!isExit);

	std::cout << "\n=> Connection terminated.\nGoodbye..." << std::endl;

	close(client);
	return 0;
}
