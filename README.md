# BelovedBlocks

Development builds available for each commit [on our Jenkins server](http://jenkins.carrade.eu/job/BelovedBlocks/).

This plugin will be soon avaible on BukkitDev.
Please note, this README reflects the last development version. Some features listed here may not be in the version published on BukkitDev.


1. [Features](#features)
   1. [New items](#items)
   2. [Stonecutter](#stonecutter)
1. [Commands & permissions](#commands--permissions)
   1. [Commands](#commands)
   2. [Permissions](#permissions)
2. [Configuration](#configuration)
3. [License](#license)


## Features

The 1.8 version of minecraft has removed the items that corresponds to some unobtainables blocks in survival. Although their corresponding items doesn't exist anymore, the blocks still exist. You can place them by doing a  `/setblock` command with some metadata arguments.

This plugin instances new items that transforms themselves into the desired special block when placed by a player.

![](http://amaury.carrade.eu/files/banner.png)

*The three seamless blocks featured by the plugin*

### Items

Each seamless block is represented by a similar item with a glowing enchantement effect (that can be disabled for each block in the [configuration](#configuration)). They also have a custom name (also configurable). The crafts are the same for the three block:

![](http://amaury.carrade.eu//files/output_K6fg1T.gif)

The crafts can be disabled (no permission yet).

### Stonecutter

The stonecutter is a tool that can smooth any of the three double slabs blocks. To use it, simply right click with this tool on the wished block and it will permute to a smooth block. Each use will decrease the item's durability by 1. The unbreaking enchantement does work when applied. The stonecutter can be crafted like shears in exceptions that the iron is replaced by diamonds:

![](http://amaury.carrade.eu//files/BB_shears.png)


The craft can be disabled (no permission yet).

The basic double slabs block → the seamless version of this block:

![](http://amaury.carrade.eu//files/blocks_transforms_small.png)

The process can be reverted (using the tool on a smooth block will turn it back into the original block).

## Commands & permissions

### Commands

A few commands allow you to get the tools and blocks added by this plugin.

The main command is `/belovedblocks`, or `/bb` (an alias).

 * `/bb give tool [receiver]`: gives the stonecutter to you, or to the receiver.
 * `/bb give block <stone|sandstone|red-sandstone> [amount] [receiver]`: gives the blocks of BelovedBlocks to you (or to the receiver).

### Permissions

The permissions tree is the following one:

 * `belovedblocks.give`
    * `tool`
       * `self`
       * `other`
    * `blocks`
       * `stone`
          * `self`
          * `other`
       * `sandstone`
          * `self`
          * `other`
       * `red-sandstone`
          * `self`
          * `other`

As example:
 * to allow someone to give to himself only some smooth red sandstone, use the permission `belovedblocks.give.blocks.red-sandstone.self`;
 * to allow someone to give any block to anyone, use `belovedblocks.give.blocks`.


## Configuration

The plugin can be configured using the `config.yml` file (it can be found at `/plugins/BelovedBlocks/config.yml` in your server's folder or [here on GitHub](https://github.com/AmauryCarrade/BelovedBlocks/blob/master/src/main/resources/config.yml)).

## License

GPLv3. See `LICENSE` file for more details.
