#include <sys/socket.h>
#include <netinet/in.h>
#include <iostream>
#include <unistd.h>
#include <cstdlib>

#define BUFF_SIZE 64

void status_trace(const char *message) {
	std::cout << "\n-------------------" << message << "--------------------\n";
	std::system("netstat -at | head -2 | tail -1");
	std::system("netstat -at | grep 56789");
	std::cout << "---------------------------------------------------------\n\n";
}

int main(int argc, char *argv[]) {
	int s, connection, size_read;
	unsigned int addr_size;
	struct sockaddr_in addr, client_addr;
	char buff[BUFF_SIZE];
	int option = 1;

	if ((s = socket(PF_INET, SOCK_STREAM, IPPROTO_TCP)) < 0) {
		std::cerr << "New socket error" << std::endl;
		return 1;
	}

	if (setsockopt(s, SOL_SOCKET, SO_REUSEADDR, &option, sizeof(option)) < 0) {
		std::cerr << "setsockopt error" << std::endl;
		return 1;
	}

	addr.sin_addr.s_addr = INADDR_ANY;
	addr.sin_port = htons(56789);
	addr.sin_family = PF_INET;
	if (bind(s, (struct sockaddr *)&addr, sizeof(addr)) < 0) {
		std::cerr << "Bind Error" << std::endl;
		close(s);
		return 1;
	}

	if (listen(s, 5) < 0) {
		std::cerr << "Listen Error" << std::endl;
		close(s);
		return 1;
	}

	status_trace("After Listen");

	while (1) {
		addr_size = sizeof(dir_cliente);
		if ((connection = accept(s, (struct sockaddr *)&client_addr, &addr_size)) < 0) {
			std::cerr << "Accept Error" << std::endl;
			close(s);
			return 1;
		}

		status_trace("After Accept");
	  
		while ((size_read = read(connection, buff, BUFF_SIZE))>0) {
			if (write(connection, buff, size_read) < 0) {
				std::cerr << "Write Error" << std::endl;
				close(s);
				close(connection);
				return 1;
			}
		}
	
		if (size_read < 0) {
			std::cerr << "Read Error" << std::endl;
			close(s);
			close(connection);
			return 1;
		}
		close(connection);
		status_trace("After close connection");
	}

	close(s);
	
	return 0;
}
