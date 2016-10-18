import primes

@profile   
def run():
   primes.primes(200)
   
if __name__=="__main__":
    run()

