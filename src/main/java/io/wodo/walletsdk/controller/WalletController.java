package io.wodo.walletsdk.controller;

import io.wodo.walletsdk.domain.Wallet;
import io.wodo.walletsdk.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Wallet create(@RequestBody Wallet wallet) {
        return walletService.createWallet(wallet);
    }

    @GetMapping
    public List<Wallet> getAllWallets() {
        return walletService.getAllWallets();
    }

    @GetMapping("/{walletId}")
    public ResponseEntity<Wallet> getWalletById(@PathVariable Long walletId) {
        Wallet wallet = walletService.findById(walletId);
        return ok(wallet);
    }

    @PutMapping("/{walletId}")
    public ResponseEntity<Wallet> updateWalletById(@PathVariable Long walletId, @RequestBody Wallet wallet) {
        return ok(walletService.updateWallet(walletId, wallet));
    }

    @DeleteMapping("/{walletId}")
    public ResponseEntity<Wallet> deleteWalletById(@PathVariable Long walletId) {
        return ok(walletService.deleteWallet(walletId));
    }
}