# define classe random
import datetime


def unix_time_millis():
    dt = datetime.datetime.utcnow()
    epoch = datetime.datetime.utcfromtimestamp(0)
    x = int((dt - epoch).total_seconds() * 1e6)
    return x


class Random:
    p = 2147483648
    m = 843314861
    a = 453816693

    def __init__(self, seed=None):
        if seed is None:
            self.xi = unix_time_millis() % self.p
        else:
            self.xi = seed

    def set_seed(self, seed):
        self.xi = seed

    def get_rand(self):
        self.xi = (self.a + self.m * self.xi) % self.p
        d = float(self.xi)
        return d / self.p

    def get_int_rand(self, max_n):
        d = self.get_rand() * max_n
        return int(d)


# define a classe Advinha:

class Advinha:

    delimitador_max = 0
    delimitador_min = 0
    rdm = Random()

    def set_delimitador_max(self, max_n):
        self.delimitador_max = int(max_n)

    def set_delimitador_min(self, min_n):
        self.delimitador_min = int(min_n)

    def gerar_palpite(self):
        variacao = self.delimitador_max - self.delimitador_min
        rand = self.rdm.get_int_rand(variacao)
        return self.delimitador_min + rand
