terraform {
  required_providers {
    digitalocean = {
      source = "digitalocean/digitalocean"
      version = "~> 2.0"
    }
  }
}


provider "digitalocean" {
  token = var.token_digitalocean
}


resource "digitalocean_droplet" "my_droplet_itnovai" {
  image  = var.droplet_image
  name   = var.droplet_name
  region = var.droplet_region
  size   = var.droplet_size
  ssh_keys = [var.fingerprint_ssh_key_digitalocean]

} 


output "droplet_ipv4_address" {
  value = digitalocean_droplet.my_droplet_itnovai.ipv4_address
}


