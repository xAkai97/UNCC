import random

s_counter = 0
r_counter = 0
previous_h = 0

# Generate random board
def initial_board():
  return [random.randint(0,7) for _ in range(8)]

# Calculate the number of conflicts
def heuristic(state):
  counter = 0
  for i in range(len(state)):
    for j in range(i + 1, len(state)):
      if state[i] == state[j] or abs(state[i] - state[j]) == j - i:
        counter += 1
  return counter

def get_neighbour(state):
  neighbour = state[:]
  lowest_h = heuristic(state)
  for j in range(len(neighbour)):
    state_copy = list(neighbour)
    for i in range(8):
      state_copy[j] = i
      new_h = heuristic(state_copy)
      if new_h < lowest_h:
        lowest_h = new_h
        neighbour = list(state_copy)
  return neighbour, lowest_h

#Stat Counter
def counter(num):
  global s_counter
  global r_counter
  if num == 0:
    s_counter += 1
  elif num == 1:
    return s_counter
  elif num == 2:
    r_counter += 1
  elif num == 3:
    return r_counter

def set_previous_heuristic(num):
  global previous_h
  previous_h = num

def get_previous_heuristic():
  global previous_h
  return previous_h

# Hill climbing with random restart
def hill_climbing():
  global s_counter
  global r_counter
  state = initial_board()
  lowest_h = heuristic(state)
  while lowest_h > 0:
    counter(0)
    state, lowest_h = get_neighbour(state)
    print("Current h:", get_previous_heuristic())
    print_board(state)
    print("Neighbors found with lower h: ", lowest_h)
    print("Setting new current state")
    print("\n")
    set_previous_heuristic(lowest_h)

    if lowest_h == 0:
      break
    counter(2)
    state = initial_board()
    lowest_h = heuristic(state)
    print("Current h:", get_previous_heuristic())
    print_board(state)
    print("Neighbors found with lower h: ", lowest_h)
    print("Random Restart")
    print("\n")
    set_previous_heuristic(lowest_h)
  return state

# Print board
def print_board(state):
  print("Current State")
  for row in range(len(state)):
    line = ""
    for column in range(len(state)):
      if column == state[row]:
        line += "1 "
      else:
        line += "0 "
    print(line)

# Print the final results & board
queens = hill_climbing()
print_board(queens)
print("Solution Found!")
print("State changes: ", counter(1))
print("Restarts: ", counter(3))
