package com.test.clase.demo.controller;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @RequestController  indica que esta clase sera un controlador de servicio Rest
 */

@RestController
public class HelloController {


    /**
     * Traza la ruta raiz "/" y envia saludo
     */
    @RequestMapping("/")
    public String index() {
        return "Saludos!!! desde Spring Boot!";
    }


    @RequestMapping(
            //Ruta
            value = "/alumnos",
            //Metodo de peticion
            method = RequestMethod.GET,
            //Que tipos de datos produce al responder
            produces = { "application/JSON"},
            //Que tipos de datos acepta(consume) en la peticion
            consumes = MediaType.ALL_VALUE )
    public String test(
            //Variable
            @RequestParam(value="name", defaultValue="Sin nombre") String name
    ) {
        return "{ \"saludo\": \"Salduos, "+name+" !!!\"}";
    }
    @RequestMapping(
            //Ruta
            value = "/alumnosA",
            //Metodo de peticion
            method = RequestMethod.GET,
            //Que tipos de datos produce al responder
            produces = { "image/png"},
            //Que tipos de datos acepta(consume) en la peticion
            consumes = MediaType.ALL_VALUE )
    public HttpEntity<byte[]> testA() {
        //Imagen PNG en base64
        String imagenBase64="iVBORw0KGgoAAAANSUhEUgAAAgAAAAIACAYAAAD0eNT6AAAACXBIWXMAAAsTAAALEwEAmpwYAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAHwdJREFUeNrs3f11E0fbB+B1Tv7HbwUoFeBUgKgApwJEBTgVRKkApwLkChAVRK4AuwLkCrAr8Ls3GgXFj4lkW7s7u3Nd5+wRz3MckGc/5jefe3B7e1sBAGX5SREAgAAAAAgAAIAAAAAIAACAAAAACAAAgAAAAAgAAIAAAAAIAACAAAAACAAAgAAAAAgAAIAAAAAIAACAAAAAAgAAIAAAAAIAACAAAAACAAAgAAAAAgAAIAAAAAIAACAAAAACAAAgAAAAAgAAIAAAAAIAACAAAAACAAAIAACAAAAACAAAgAAAAAgAAIAAAAAIAACAAAAACAAAgAAAAAgAAIAAAAAIAACAAAAACAAAgAAAAAgAACAAAAACAAAgAAAAAgAAIAAAAAIAACAAAAACAAAgAAAAXfhZEZCzg4ODUf0Rx1F9HG58xvHigX/dTX1cpD8vN4/b29uF0gaKer7WDz6lQC6V/VGq4NfHy5a/wlUKBIt0XNT3x7UzAwgA0EzFH635eQcV/i4uNwLBQiAABADYXwA4rT/e9eTrfkphYF7fO0tnDxAA4PGt/689/frRO3CawoCeAaBXrAKga5Mef/eYhPghAkwdZGb1MXY6AT0AsFsPwEX18Nn8OYuJhNP6vpo5u4AAAPdX/qP648tAf71YchjDA6eGB4AcGQKgSycD/t2e1ccf9bGsg840zXUA0APAIFrwk+r7mv2wqI9o7Ua3/n+uoU8V4jJVlCW4Sb0BU1cOIADQ54o/KrLnW370MoWBRQoEFxt/x6z+eFNg8cUcgZO6LOauJEAAoC8V/zhV/E/ZsOe8Wm3t+7zw4oxymNhLABAAyLniP0wV/zulsXd/GhYABAByrPyP649ZVc5YfRcuU2/AhaIA2mIVAD9s9ddHjFN/VPk3LvZB+FyX94miAPQA0GXlP65WL+dR8bcv5gYc2zsA0ANA25X/tP74W+XfmZhguUyvRgbQA0DjFX/Or+Qt1VtbCgN6AGiy8o/W5oXKPzsf0n4JAHoA2Hvlb5Z//swLAAQA9lr5T6rV62zJXywVHAsBwL4YAii38j9V+fdKLBVcmBwI6AHgKZX/rCpzH/4huEk9ATYNAvQAoPIvyDM9AYAAgMpfCAAQAFD5FxYCZmn/BgABgHsr/xOV/yCtJwYKAcDD6waTAAdf+U8qs/2H7ry+j8eKAdADwLryH6v8i/DSjoGAHgDWlf+oWm3va4e/cnh3ACAAFF75x5jwolqNEVOWV/U9vVAMwDaGAIbpVOVfrLlJgYAAUGbrf1KZ8V+yGPKZKwZAACir8j9KrX/K9jIt/QT4cZ1hDsCgAkBM+tP1z9qv3hkA6AEYfuU/Vflzx0wRAALAsCv/6Pr/Q0lwx4sUDAH+t+4wBDCIALCoP14qCX7gl/o+XyoGQA/AsCr/icqfLWaKANADMKzKP9Z7R8vObn9s81t9r1seCOgBGIgTlT87sjwUEAAG0vofVSb+sbvnJgQCAsAweJjzUCe2CQYEgP63/m33y0PFcJEdAgEBQOsfvQCAAIDWP3oBAAEArX/0AgACAHm0/uOhfawk2EMvgOsIBAB6ZFJZ989+TBUBFN6otBNgr3oAlvXHcyXBnryq7/+FYgA9AORd+Y9V/uzZRBGAAICHNeV5YzIgCADkz6QtXFeAAFCS9Mpfk/9ogj0BQABAK40CvUibSwECABkaKwIETEAAKEjdOouHs+5/BExAAPBwhr16bTUACADkR/csgiYgAJQkTc6y+Q8CACAAeCiDaw0QAIbuSBHQkhfmAYAAgFYZrjdAAKDLVpkioEV6nEAAoGvp7X+gBwAQAAozUgS45gABwMMYmvbcREAQAOjeWBHQAfMAQACgY1pidGGkCEAAoFtWACAAAI05uL29VQq5nZTVOOxXJQHQC+f1cVEfi7pOnQsAPCUAjOuPv5UEQO9c1cdpfczq+vU65y9qCAAA9ide4PY+egTqxlzWb3MVAPJkAiBA/4PAxzoEnAoAPISlWADD8K4OAYsc99gQAACgWS/rI7vJgQIAALQQAnIbDhAAAKAd73KaGCgAAEB7TnOZDyAAAEB7YnXAJIcv8rNzAdzx6vb2dqEY4MfShm3Rko8u/TcP/M9PqtVmQXoAgKxcKAL4bxGSY9vf+ojW/K/1cfmQXoAc5gIIAMDdB9u1UoAH3TMRmscPDAFjAQAAhhGcJw/4Tzrf8E0AAID99QSc7fjjLwUA7rNUBAC91JvXAQsAAgBsulQE8CS9mUMjAAC9fHhBpnqzikYAcAEBsCd9WkUjALiAYNNCEUAZBIB8XSkCAASA8iwVAXoAAAGgPOYBIHgCAoAHMTTv9vbWdQcCAHoAKMy5IgABgO5bYgulgNAJCABlsisbAgAgAHggg+sNEABKsFAEtOQmvckMEAAQAHCtAQIArUtLsuwIiAAACAAFmisCXGeAAKBlBvt2ZQMgEADITP1gjpbZjZJA6x8QAPQCwD7NFAEIAGihUZYry/9AACDvAGAYAOESEABKUrfQrj2oachMEYAAgAc1ZbnU/Q8CAFCea0UAAgD5O1QE7NmRIgABAA9ryvNMEYAAABTo4OBgpBRAACBvHtS4rgABwIMaAAQAAEAAAAAEAABAAOippSIAQAAQAMB11VMHBweL+rjdcoyUFAIA0Ijb21sBoP3KP3b1fLnlxy6dGwQA1ry0hX3ziulujHf4mYViQgBgzYtbECoFABAASnN7e+uBgAAwDMc73O9zxYQAwKZLRcAeLRVBu9LEvudbfuyTkkIAQIuNJi0UQX6tf+cFAQAPBpp0c3t7K1C2b+w+JxcH9UNAKfTlZK2WD31VEuzBWX3vTxRD6/fwtgfuVX1eRkpq8Of5m/pcH+gBoNrxYomVAOYBsA8mmbVfKej+JysCQP+cKgKe6MYs806MBTMEAJ7acrOBC1r/wwwAegAQALhfGgbwAOcppoqgXWn534stP3ae7m8QAPAAZ+/O7TGv9Q8CQH97AeIBfqYkeIQTRdCJXSYA6tmjVZYB9vXErZYERhB4pjTYkaV/3d2v11vu1ZiYeaikBnO+LQOk0V6AeKBMlQQ7utH6X43F18e0PuYt/pvjHYL6/AF/X3z/Wfp7QQAoNATEkkD7hrOL45InmEVlmSr9L/XxR3202drepaJePPDvfFMff9e/07I+JqlHEASAwkwqmwPx334v8W2SUSmmynEZlWV9vO4qfO3wM4/tkYgXC32ojwgCp2m1AQgAhfQCXKcHjL0BuM9Z6ikqqeKPbv74nZepcnze4XeJlvm25X+Xe+idiSGGd/XxJXo6dtx1EAGAAYSAeNAd6Qngjr9KmvQXlV59LKpVN/+7Ko8Jsl1s/xs9HR/T8MCJ4QEEgDJCwLgyJ4BVb9Bv9TUx+El/qZv/JHXzf6yPl5l9xfEOP9PUhMTo+XhfrYYHYtLgkVsDAWC4IeC6PqLF8ao+rpRIkWJ/iNHQ9/qPyiwqtWr1dsz3VYfd/E/sAbhpYX5G9ITEpMHP0UMS8yLcJoSfFcEgg0A8UEYp8cfNfpQOewYMTwz7ROs3zvls6DP9U+U1ybClf29I2eGeW7T8taLcXsZSwrhe6uPU9sMCAMMMAhfVnbXfqav0udLpvd9LmdyXZravK/4+XbvjHX6mq56aKMdYDvlHXb5nKTwu3FZlMQRQHtuNOo99qfjHqZt/vXa/b8G1iwmAj7HeU+DC8IAAwLCdKoLe+zTUF/psrN2P3qu/U+XUy9+j2j5McZXZeYzlih9i22J7CggADFB64JwriV6bDbDiv7t2/0VD/1RMjv19x9b5U4x3+Jn5I+/haf3xW9Xcip+7ewqM3XICAHoB6N7VkGb439mit8m1+zHO/aouu1gh0cbEt0a7/+MaSCt+fqmPv6rmNgKLPQVsOTxQ3gZY6ok3GbCv3tb37Kzn115UIpNqNUG1yWswWvtRVrO2u9p3ub/2/Sa4llZI3KSei+lQh6H2dC568TZAAaDcCzQeFB+URK/Ew3fU12VbaUx5mlrHTS5JjSGu0656StLv+WXLj31KLXjlLAB0xhBAueaV9wf0TS/XbN/ZovdNQ5VSXMvRFf5LXUbjjiulTmf/R8s8bQEdQeBt1dwW4dHTsN5yeGp4oIdBRQ9A0Sk1Wgl/KAmt/wauragMoos/KqImu/mjFTrLaVgkzWnY9ubBX9M+HW19p3E6F02vqjhLQfWi5JvVEAB9eUgvKzsE9sGfafZ37tfUUar4m6xo1uPQWVY0Ozz8YyLnqMN7flI1P/8iu2AmAPwvQwAFS61JKwL60frP+jxtrN3/3GDlH5P6oks7ekImmVb+WW/+k94XcpoCSJNLCWN4YL2nwNSeAnkSADitzAXI/hzl2PWf1u7Hwz2+W5Nr9zeX8OX+voPxDj+TxaS5O0sJ/6yaeYFY9C7GMOOX9EbCsds5o3vYEABWBGTf+s9q7L+l8eSrFE579YKj1AuyLQj9X66/U0tLCePcTiMIDfVFROYA0LcLdlnZFyBHWbz0J40dH6cHd5PXyadU6c97eA+Nqu3L/85jlUJPfpf1JM6m5ghFuJ1Vqx6upQDQPkMArE0UQXYuu67879mit4nKPyqC6IKOJXzHPV5XvkvFvujDL5KWEkYAiCDQ1FLCu1sOH7vl9QDQ3cN+l+VLtOdVV69oTQ/jqACa7Aoe1EzxHJf/7fn3a2OFRy+HfvraAyAA8K/WXv1xUVkWmIOztJlLF9fBsmqum3/I3b7XW+6dm/p3PhzA79nGUsK4Tk76Gg4NAdA76YE8VRKdu0kP16408VCPLuT1Er6TAVb+4x2C83wgz4nNpYSvqmaWEkZZjjwKBADavbmj+83rgrs1GdDs6FjCF93eRz1YwvcUWa//b/B5sWhhKSECAG1WQJW9AbryaQAvV4lK4PdqtdxtUsi2sOMSA8BGEIhJg9ONDYY0IgQA+nozV4YCunBT9Xs1xuaGPacDbu3/SxoT37b2/7KU1+emDYbGqVfgL40JAYD+3cQxFPBJSbTquKeVZozv/5Ja+4sSz1vJrf8tvQInaeLjmdtbAKBfojVqTK8df/a48ozW70XsF1Donu/jHX5mXlqhRM9IfZykVSVv3OIZniPLANlyE8fa389KolFZ7Q636xKm//p9qtUyv3kh90gRy/8e+MyIVSzH1dOWFPfiDZhPuYcsAyRraQLXWyXRmKtqty7kPonNgz5Gyy+9LGiwlV+q7LZVcotCKv54I+Si+v5GSPuJZE4AYJcQMKtWk3nYr5gcdTzgyXKxn0C8Ce7rgN8EV/T4/z1vhHzpthYAGF4IiC49kwL3K9clck3M+4gW4d+pV2AyoF6BXULN4IZCYqvotPXxlxTy9t3aj3C89Iho+DyaA8ADbvrD1Jp5oTSe7G3O25y28C6Am1QxTvu6PC7dD1+3ham0Nn4o9/+kanYLYO8C0ANApr0A16nFc6k0hlv5p3O9uZb7rNr/Wu5nqVcg3gS3SO+h1/rPszI7iiGcFHbeN1T5x8TR30rbQ6JrAgBCQLv+6tMLTtJa7qicoxX7e9XM8ED0MnzYmDTYlxbzoMf/01BNDFGtJ/Xt200Kl7GHxLiUVSNZnWNDADzy4WA44OE6e8Pfns99G68KjvkmpznvjbDLWxO77uJ9xO80Suc2rtOmZvEPopt/Szl6HTBCAP94O5T33t+pLKbV09d7966y2HF/jKz2d8gg1BWzP4Q5AAye4YByK/90/tsYHogWdow7L9NSwqNMfv1dKvasK7q0U9809WR8bKjy182f8zWgB4A9PUyigrPd5/8+/CYlPfTSWv9oSb5u8J+5TC3JWYe/53yH3/HXHJd5pnM0afh+HXw3/xB6AAQA9nnRT6vVmmDSDn+FvAr3vmthVDU/lhwBa5bCwDKzB3xWy//ScN26m7/JIbuitoEWAODfF348ZD4WXgzn1bB3+HtMxRPh8HmD/9Sn1NqcZ3KNZzHhs6V5Gp0FMQHgacwBYK+M8X17gclY5f/P9XAdXfWpNfyqam43yeiOX79/4KThnQbHO/xMp/fBxr78sVNfU/vyRy9XvCdklF77q/LvW1DRA0BX6XeILf++zPrOoFXa9PDAt1Z46hVY7Pn7R0W3rTfj/9oOgalcJ+lourfltMevr9YDIAAgAAgAHV8nbQ0PfJs0GK3yp1bKqZL9su3fq/+doxbLcVw1P6lPN/8AA4AhAKATLQ4PxKS3eFNdDA+cPnGnwV0CXhvzEA5TN39Uxn83WPnr5h8wAYCmHhrwkDCwqI/oDYh3D/xV7f/dAyGGG95Vq/cPzB75d+yy/W+jASC9N2GZQk1TPScRxl6lvfln5rQIALArrQQeGwSW6dXTo9TybCpMPrYXYFsPwE0LSz9HVTNzJ25S+IpNe46N8QsAAF0EgbaGBx7S8h7vUPH2cRWMbn4BACDLMNDG8MAuhvb2P938AgBAL4JAW8MDPzIeQADQzY8AQKMOFQENBoHWhwfSyoFtW+heZtx9rpsfAYBWlPp64COnvvUwsDk88GfV3PBAX1v/uvkRAGhHWqJUqmdpohjtB4EYHpjWx2Fq6e77FdW7nNdcJgDq5kcAoBMnhf/+U5dA52Fglnbii+GBsz39tcc7/LtdV7QRet5GCNLNjwBA263/pl812gcvC+8FySkILNIb+Z40PFCfzwgT25b/dblMMUJOdPMfRfhx5hEAaLvyH9cf75XEN6ep0iCPIPDU4YEcl//dpFAT3fwT3fw86rntZUDsofKPB+SsavbNbn0TD+hxC7vC8bhrdrRrF3n9s3EOt/Vs/dJWl/tDvjudXV/eBkgRF/qJlv9/eqtbttfXd/QafN3yY1dpSSL0KgAYAuDRrZD6WKj8t/pQl9M8VST0z3iHn5krJvpIAODBLaL6mNZ/jG7Rl0pkJ6+r1atop4JA7wxt+1/4/jw3BMCuFX+1WuIXh7H+x4sd2Wb1cWpTll5c98tq+yt3/8+55M51Yw4Ag7iQx/XHpD7eKI29ikmC8xQETBTM89qPlRyft/zYeX3+xkqLPgYAQwDcd/HG+P5pav38rfJvxLNUrp+jnGMyZdpvnnzsUrEb/6e/z3o9AKwr/Wo13hmt/RdKpDOxRn0WFYulXp3fE4tq+zyXX/Xg0NceAAGg7Iv0KFX4UfE/VyLZhoGFSibLh7jlf/Q6APzsVBV3YUZlP1bp90L0xLxP5y0mD85Tz8BC0bRyn2zjPNBrAsDwH2SHqbJfV/pm8PdThLV3cdTndD2BcJ56B8xA37+xAMDg6wdDAIOs9Eepso/DWv3h+5QqI/MG9ncPLSvL/3j89WMOAK1ecOONSl/XfrkuUxiYmTfwpAD9ZVs5p1cOQ28DgCGA/l5guva5z4t0GCp4vF3G/y3/o//1iB6A3rVMdO3zWIYKdrvPonJ/veXHLP+j9z0AAkD+F9K40rXP/hkqAAFAAMjswomu/c1KX9c+TftnqKB+HujaBgGAFi+WUfV9PP+1EqFjn6rv8waWigMEAPZ7gRxttPJtvUuubE0MAgB7uCjGlfF8+mu9G6F5AyAAsMOFcFwZz2eYYWBRmTcAAgD/nHjr8ymNSYQgABRf6cdhEh/CwPfeAZsPIQAIACp9KNCnjd4BYQABQABQ6UOhPQOGCRAABIBenUwT+UAYAAGgkBMY6/RPVPrQKEsLEQAEgCxO2qj+mKTDOn1oPwycVjYdQgAQAFo8WetK3xv2IA+fUq+AIQIEAAGgkdb+Sar4dfFDnmK+wCx6BvQKIAAIAFr7UKbzFAT0CiAACAA7n4zDjda+sX3ot/VcgZm9BRAABIAfnYRR/TGtjzcuSRgcwwMIAAKAih8Kdxb3vCCAALC7n4ZW8ddHtAi+qPyhKHG/f4n7PzUAgBJ6ANIY/6lKH0j+rFZDA+YIoAdgqAGgLuiY3DetLOUD/i3mCEysGkAAuN9PPS7g6O5f1H98r/IH7hHPhY/1c2Keegmhjbpp3Jfv+lNPCzj25499w63lB7aJN3cu0/s9oGm9CZu9CwBpI5+PWv3AA3sDPqfnBzTpuDf1aZ/mAKTx/veuL+AJ3tbPvZlioIE6KnqZPu/6813PAfi5RwUbN6xZ/sBTfaifJ5UQwJ7rqOj679U19VNPClblD+w7BEwUA3ts+S/q40WfvvfPPShYlT+gJ4AcK/1RtRrz72UdlfUcAGP+AAyVjYB+XPlPIqG7RAAQAAoJABvjKZb6ASAAlBAA0kzK2OTnucsDAAGgGTmuApip/AGgoACQtvh97bQAQMN1bi5DAKnrf1kZ9wegAIYAvpuq/AGgoB6AeLVv/fHF6QBAD0BZPQBTlwIAFNQDkMb+vzoVAOgBKKsHYOIyAAABAABoWKdDACb/AVCq0ocAjl0CAIN3VR9v6+NVVHpdHfHvp+9x5ZR03wOwqD9eOg0Ag3VWHyd1XXOdTcW3mnx+Wh9vSu4B6DoA3Lo3AIbb8q/rmFGWrd8MXjxX7BBAeuUvAMM1zfWLpR6Jacknp8s5AAIAwLAtfT8B4D4j9wYA6AEAYFhGvp8AcJ9D9wbAoE3TZLvspO81FQAkLwD2L2bYn+YWAjaWAT4v+eR0tgzQEkCAYlyl1vayrnMWHVb6R6nxOc2h8i92HwABAICSeRsgACAAAAACAAAM0XmRASC9BhgASnXR9RcwCRAA2vdrXf92GgIEAABoVxZvSTQHAADadZrDl9ADAAAttv7r4yi9jlgPAAAU4iSHyl8AAID2/FVX/vNcvkyXQwDLqvAXMQBQjPO6vh3n9IW67AFYuh4AKKHyr4/j3L6UIQAAaE50+49zGfff9LNzAwB7F7P9T3Ia88+pB2Dh+gBggBX/79Vqqd885y+qBwAAnibG+GNb30Xulb4AAPAwv/XpwQ676HII4ELxAz1xrQgQANxQACAACADA0N3e3i6UAkPT2U6A3/5xLwQC+hEADpQCegAAynKpCBAA3FhAeQxXIgC4sYACLRUBAsD+WQoICACgBwAgO55TCAB6AIACeU4hAEjWQIGWioAh6nofgMP646vTAOTKHgDoAWjmxtIDAOTMUmUEgAadOw1ApjRSEAAatHQagEwtFAECgAAAlMfzCQFAwgYEABiOTlcBfPsCBwej+uOLUwHkxgoA9AA0e4NJ2ECOrhQBAkDzrAQAcmMHQAQANxogAIAA4EYDSrBQBAgAzZvXx5nTAWTiTMOEoet8FcC/vsxqRcC0Pt44NUDLburjtD5mJicjAHQXBOIlQSfpeOY0AS1U/KfeT4IAkFcQmKQg8NzpAvYolvlN62fgTFEgAOT8RQ8OJikMvHTagCc4T639uaJAAOjTFz44OEo9AuYJAA9xllr8S0UBPQwAG0FglHoE4jA8ANwnuvnXE/uM78MQAsCdMLAOAoYHgPApVfq6+WHIAeBOr8C0Po4rqwegNDGbf1atxveXigMKCgAbQeAwhYCYK/DCaYZBO0+t/ZmigMIDwJ0wEJMGJ+nQKwBa+0AJAeBOGJiknoHXTj30krF9EACeFARGlRUE0BfrmfxzrX0QAPYZBtb7Cpg4CPlYd/FHa99LeUAAaDwMTCpDBNCls9TS18UPAkAnQWC9iiACgb0FoFkxrj9PFb/NekAAyCYMjDbCgCWFsB+X1fcufpU+CADCABRQ6ZvMBwKAMAAqfUAA6H8YiMOcAUq3HtNfqPRBACgpDBxuhAGrCSjBzbrCr0zkAwGAfwLBOgyMK5sOMRxXG618S/ZAAGBLGDhKQWBSmTdA/5xvVPo25wEBgEeGgcONngG9A+Tayl9sVPq69kEAoMHegTjMHaALN6nC/1bpm8AHAgDdBILxRiCwsoCmnK8r/fpZsFAcIAAgEKDCBwQABAJ6KLr0L1T4gAAw7ECwnkOw/jSpsDyXGxX+hZn6gABQZiA43AgD62DwTMkMqnW/uFPhm6UPCADcGwpGKQgcCQW9cpUq+n8OM/QBAYB99hSM0mFOQXdikt7yTmWvZQ8IALTaWzASDBqxnpy3TMciPrXqAQGAPvQYrENB/Hn9/xlO+HElH3++NhMfEAAYakBYB4J1QFiHg2pAIWFduVfrin2jor82+x4QAODHQWG88T83/7wODpuaCg6bFXl1p0Jf+6fFrvUOCAAAQK/9pAgAQAAAAAQAAEAAAAAEAABAAAAABAAAQAAAAAQAAEAAAAAEAABAAAAABAAAQAAAAAQAAEAAAAAEAABAAAAAAQAAEAAAAAEAABAAAAABAAAQAAAAAQAAEAAAAAEAABAAAAABAAAQAAAAAQAAEAAAAAEAABAAAAABAAAEAABAAAAABAAAQAAAAAQAAEAAAAAEAABAAAAABAAAQAAAAAQAAEAAAAAEAABAAAAABAAAQAAAAAQAABAAAAABAAAQAAAAAQAAEAAAAAEAABAAAAABAAAQAAAAAQAAEAAAAAEAABAAAAABAAAQAAAAAQAAEAAAQAAAAAQAAEAAAAAEAABAAAAABAAAQAAAAAQAAEAAAAAEAABAAAAABAAAQAAAAAQAAEAAAAAEAABAAAAAAUARAIAAAAAIAACAAAAACAAAgAAAAAgAAIAAAAAIAACAAAAACAAAgAAAAAgAAIAAAAAIAACAAAAACAAAgAAAAAIAACAAAAACAAAgAAAAAgAAIAAAAAIAAJCT/xdgADbby5Zf2+ooAAAAAElFTkSuQmCC";
       //Conversion de Base64 a Bytes
        byte[] bytes = Base64.decodeBase64(imagenBase64);
        //Cabecera de HTTP para respuesta
        HttpHeaders headers = new HttpHeaders();
        //Tipo de contenido de respuesta
        headers.setContentType(MediaType.IMAGE_PNG);
        //Tamaño de respuesta
        headers.setContentLength(bytes.length);

        return new HttpEntity<byte[]>(bytes, headers);

    }


    /**
     *
     * @CommandLineRunner, sirve para crear una acción mientras al inicio de la aplicación
     *
     */

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Inspeccionar los beans que provee Spring Boot:");

            /**
             * Le pide al contexto (ctx) los bean definidos
             */
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.err.println(beanName);
            }

        };
    }

}
