# **************************************************************************** #
#                                                                              #
#                                                         :::      ::::::::    #
#    Makefile                                           :+:      :+:    :+:    #
#                                                     +:+ +:+         +:+      #
#    By: dkhatri <marvin@42.fr>                     +#+  +:+       +#+         #
#                                                 +#+#+#+#+#+   +#+            #
#    Created: 2023/05/17 16:32:10 by dkhatri           #+#    #+#              #
#    Updated: 2023/05/17 16:47:30 by dkhatri          ###   ########.fr        #
#                                                                              #
# **************************************************************************** #

JAVAC = javac
J_FLAGS = -d .
NAME = avaj

MAIN = avaj_launcher.java
AIRCRAFT = Aircraft.java AircraftFactory.java Flyable.java Baloon.java \
		   Helicopter.java JetPlane.java
TOWER = Tower.java WeatherTower.java WeatherProvider.java
COORDINATES = Coordinates.java
PARSER = parser.java

PACKAGE = fr

SRC = $(MAIN) $(AIRCRAFT) $(TOWER) $(COORDINATES) $(PARSER)

all: $(NAME)

$(NAME):
	@$(JAVAC) $(J_FLAGS) $(SRC)
	@echo "\033[1m$(NAME)\033[0m \
		: Compiling $@ \033[1;32m[OK]\033[0m"

clean: 
	@/bin/rm -rf $(PACKAGE)

fclean: clean

re: fclean all

.PHONY: all fclean clean re
